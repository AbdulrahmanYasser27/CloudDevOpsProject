provider "aws" {
  region = var.region
}

module "network" {
  source               = "./modules/network"
  vpc_cidr             = var.vpc_cidr
  public_subnet_cidrs  = var.public_subnet_cidrs
  private_subnet_cidrs = var.private_subnet_cidrs
  availability_zones   = var.availability_zones
}

module "server" {
  source           = "./modules/server"
  vpc_id           = module.network.vpc_id
  public_subnet_id = module.network.public_subnet_ids[0]
  instance_type    = var.instance_type
}

module "eks" {
  source             = "./modules/eks"
  cluster_name       = var.eks_cluster_name
  vpc_id             = module.network.vpc_id
  private_subnet_ids = module.network.private_subnet_ids
}

module "ecr" {
  source    = "./modules/ecr"
  repo_name = var.ecr_repo_name
}
