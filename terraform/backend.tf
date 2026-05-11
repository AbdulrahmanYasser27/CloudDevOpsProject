terraform {
  backend "s3" {
    bucket = "clouddevops-terraform-state-781978598486"
    key    = "terraform.tfstate"
    region = "us-east-1"
  }
}
