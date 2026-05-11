output "jenkins_public_ip" {
  value = module.server.jenkins_public_ip
}

output "eks_cluster_endpoint" {
  value = module.eks.cluster_endpoint
}

output "ecr_repository_url" {
  value = module.ecr.repository_url
}

output "vpc_id" {
  value = module.network.vpc_id
}
